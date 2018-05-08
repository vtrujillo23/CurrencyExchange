package com.moneyxchange.persistence.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.moneyxchange.persistence.util.ObjectUtil;


@Component
public abstract class AbstractService<T,S,U>{
	protected CrudRepository crudRepository;
	protected Class<T> typeT;
	protected Class<S> typeS;
	
	public S save(S obj) {
		T objrep=(T) ObjectUtil.convertObject(this.typeS,this.typeT,obj);
		crudRepository.save(objrep);
		return (S) ObjectUtil.convertObject(this.typeT,this.typeS,objrep);
	}
	
	public S delete(S obj) {
		T objrep=(T) ObjectUtil.convertObject(this.typeS,this.typeT,obj);
		crudRepository.delete(objrep);
		return (S) ObjectUtil.convertObject(this.typeT,this.typeS,objrep);
	}
	
	public S find(U obj) {
		return (S)  ObjectUtil.convertObject(this.typeT,this.typeS,crudRepository.findById(obj));
	}
	
	
	public List<S> findAll(){
		return (List<S>) ObjectUtil.converListObject(this.typeT,this.typeS,(List<T>)  crudRepository.findAll());
	}
	
}
