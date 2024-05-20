package com.nabilla.myasset.repository;

import com.nabilla.myasset.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}
