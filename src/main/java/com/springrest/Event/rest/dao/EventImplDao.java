@Repository
public class EventImplDao implements EventDao {
    private EntityManager entityManager;

    @Autowired
    public EventImplDao(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Event> FindAll() {
        // create a query
        TypedQuery<Event> theQuery = entityManager.createQuery("from Event", Event.class);
        
        // execute query and get result list
        List<Event> events = theQuery.getResultList();
    
        // return the results        
        return events;
    }

    @Override
    public Event findById(int event_id) {
        Event theEvent = entityManager.find(Event.class, event_id);
        return theEvent;
    }

    @Override
    public List<Event> findByLocationId(int location_id) {
        TypedQuery<Event> theQuery = entityManager.createQuery("from Event Where location.location_id=:location_id", Event.class);
        theQuery.setParameter("location_id", location_id);
        List<Event> events = theQuery.getResultList();
        
        // return the results        
        return events;
    }

    @Override
    public void save(Event the_event) {
        // Check for conflicts
        boolean conflictExists = checkForTimeConflict(the_event);
        
        if (conflictExists) {
            throw new RuntimeException("An event at this location during the specified time already exists.");
        } else {
            // Save the event
            Event dbevent = entityManager.merge(the_event);
            System.out.println("Event saved with ID: " + dbevent.getEvent_id());
        }
    }

    @Override
    public void deleteById(int event_id) {
        Query theQuery = entityManager.createQuery("delete from Event where event_id=:event_id");
        theQuery.setParameter("event_id", event_id);
        theQuery.executeUpdate();
    }

    private boolean checkForTimeConflict(Event the_event) {
        // Query to check for events at the same location that overlap in time
        TypedQuery<Event> theQuery = entityManager.createQuery(
            "from Event where location.location_id = :location_id and Date = :date and " +
            "(StartTime < :endTime and EndTime > :startTime)", Event.class);
        
        theQuery.setParameter("location_id", the_event.getLocation().getLocation_id());
        theQuery.setParameter("date", the_event.getDate());
        theQuery.setParameter("startTime", the_event.getStartTime());
        theQuery.setParameter("endTime", the_event.getEndTime());
        
        List<Event> conflictingEvents = theQuery.getResultList();
        
        // If there are any conflicting events, return true
        return !conflictingEvents.isEmpty();
    }
}
