package com.alvarez.dojosandninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alvarez.dojosandninjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo,Long>{

}
