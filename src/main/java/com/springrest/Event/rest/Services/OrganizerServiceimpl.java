package com.springrest.Event.rest.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springrest.Event.rest.dao.OrganizerDao;
import com.springrest.Event.rest.entities.Organizer;


@Service
public class OrganizerServiceimpl implements OrganizerService {
	
	private OrganizerDao organizerDao;
	@Autowired
	public OrganizerServiceimpl(@Qualifier("organizerImplDao")OrganizerDao organizerDao) {
		this.organizerDao=organizerDao;
		
	}
	@Override
	@Transactional
	public List<Organizer> FindAll(){
		return organizerDao.FindAll();
	}
	
	@Override
	@Transactional
	public Organizer findById(int organizer_id) {
		return organizerDao.findById(organizer_id);
	}
	
	@Override
	@Transactional
	public void save(Organizer the_organizer) {
		organizerDao.save(the_organizer);
	}
	
	@Override
	@Transactional
	public void deleteById(int organizer_id) {
		organizerDao.deleteById(organizer_id);
	}
}
