package edu.bigdata.training.testservice.service;

import edu.bigdata.training.testservice.controller.model.Person;
import edu.bigdata.training.testservice.dao.TestServiceRepository;
import edu.bigdata.training.testservice.model.PersonEntity;

import java.util.List;
import java.util.UUID;

public class TestBusinessLogicService {

    private TestServiceRepository testServiceRepository;

    public TestBusinessLogicService(TestServiceRepository testServiceRepository) {
        this.testServiceRepository = testServiceRepository;
    }

    public PersonEntity processCreate(Person person){
        PersonEntity personEntity = new PersonEntity(person.getName());
        testServiceRepository.save(personEntity);
        return personEntity;
    }

    public PersonEntity processGet(String id){
        return testServiceRepository.get(UUID.fromString(id));
    }

    public List<PersonEntity> processGetAll(){
        return testServiceRepository.getAll();
    }

    public PersonEntity processUpdate(String id, Person person){
        PersonEntity personEntity = new PersonEntity(person.getName());
        personEntity.setId(UUID.fromString(id));
        return testServiceRepository.update(personEntity);
    }

    public void processDelete(String id) {
        testServiceRepository.delete(UUID.fromString(id));
    }
}
