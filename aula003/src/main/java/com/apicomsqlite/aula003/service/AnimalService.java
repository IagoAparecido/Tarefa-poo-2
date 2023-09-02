package com.apicomsqlite.aula003.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.aula003.enity.Animal;
import com.apicomsqlite.aula003.repository.AnimalRespository;
import jakarta.transaction.Transactional;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired(required = false)
    private AnimalRespository animalRepository;

    @Transactional
    public String createanimal(Animal animal) {
        try {
            if (!animalRepository.existsById(animal.getId())) {
                animal.setId(null == animalRepository.findMaxId() ? 1 : animalRepository.findMaxId() + 1);
                animalRepository.save(animal);
                return "Animal cadastrado com sucesso.";
            } else {
                return "Animal já existe no database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Animal> readanimal() {
        return animalRepository.findAll();
    }

    @Transactional
    public String updateanimal(Animal animal) {
        if (animalRepository.existsById(animal.getId())) {
            try {
                Optional<Animal> animals = animalRepository.findById(animal.getId());
                if (animals.isPresent()) {
                    Animal animalToBeUpdate = animals.get();
                    animalToBeUpdate.setNome(animal.getNome());
                    animalToBeUpdate.setEspecie(animal.getEspecie());
                    animalToBeUpdate.setIdade(animal.getIdade());
                    animalToBeUpdate.setRaca(animal.getRaca());
                    animalRepository.save(animalToBeUpdate);
                    return "Animal atualizado.";
                } else {
                    return "Animal não encontrado no banco.";
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Animal não existe no banco.";
        }
    }

    @Transactional
    public String deleteanimal(int id) {
        try {
            if (animalRepository.existsById(id)) {
                animalRepository.deleteById(id);
                return "Animal deletado com sucesso.";
            } else {
                return "Animal não existe no banco de dados.";
            }
        } catch (Exception e) {
            throw e;
        }
    }
}