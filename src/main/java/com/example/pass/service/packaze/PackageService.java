package com.example.pass.service.packaze;

import com.example.pass.repository.packaze.PackageEntity;
import com.example.pass.repository.packaze.PackageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PackageService {
    private final PackageRepository packageRepository;

    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    public List<Package> getAllPackages() {
        List<PackageEntity> bulkPassEntities = packageRepository.findAllByOrderByPackageName();
        bulkPassEntities.forEach(pass -> {log.info("### aa = {}", pass.getPackageName());});
        return PackageModelMapper.INSTANCE.map(bulkPassEntities);
    }
}
