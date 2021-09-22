package com.alvarez.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alvarez.dojosandninjas.models.Dojo;
import com.alvarez.dojosandninjas.models.Ninja;
import com.alvarez.dojosandninjas.repositories.DojoRepository;
import com.alvarez.dojosandninjas.repositories.NinjaRepository;

@Service
public class AppService {

	private final DojoRepository dojorepo;
	private final NinjaRepository ninjarepo;
	
	public AppService(DojoRepository dojorepo, NinjaRepository ninjarepo) {
		this.dojorepo = dojorepo;
		this.ninjarepo = ninjarepo;
	}
	
	public List<Dojo> findAllDojos(){
		return (List<Dojo>)this.dojorepo.findAll();
	}
	
	public Dojo createDojo(Dojo d) {
		return this.dojorepo.save(d);
	}
	
	public Ninja createNinja(Ninja n) {
		return this.ninjarepo.save(n);
	}
	
	public Dojo getOneDojo(Long id) {
		return this.dojorepo.findById(id).orElse(null);
	}
}
