package com.asta.Insurance.service;

import com.asta.Insurance.model.Insurance;
import com.asta.Insurance.repository.InsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;

    public List<Insurance> getAll(String query) {
        if (query != null) {
            return insuranceRepository.findByQuery(query);
        }
        return insuranceRepository.findAll();
    }

    public Insurance getById(Long id) {
        return insuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteInsurance(Long id) {
        insuranceRepository.deleteById(id);
    }
    public void updateInsurance(Long id, Insurance updatedInsurance) {
        Insurance insurance = this.getById(id);
        insurance.setSum(updatedInsurance.getSum());
        insurance.setAgent(updatedInsurance.getAgent());
        insurance.setClient(updatedInsurance.getClient());
        insurance.setDateOfInsurance(updatedInsurance.getDateOfInsurance());
        insurance.setDurationOfInsurance(updatedInsurance.getDurationOfInsurance());

        insuranceRepository.save(insurance);
    }
    public void save(Insurance insurance) {
        insuranceRepository.save(insurance);
    }
}
