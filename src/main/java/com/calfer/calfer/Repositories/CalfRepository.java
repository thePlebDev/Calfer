package com.calfer.calfer.Repositories;

import com.calfer.calfer.Models.Calf;
import com.calfer.calfer.Utils.CalfSex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CalfRepository extends JpaRepository<Calf,Long> {


    // sortByWeight

    @Query(value = "SELECT * FROM calves WHERE calves.tag_number = ?1",nativeQuery = true)
    Optional<Calf> findByTagNumber(String tagNumber);

    @Query(value = "SELECT * FROM calves WHERE calves.calf_sex = ?1",nativeQuery = true)
    Optional<List<Calf>> findAllCalvesBySex(String calfSex);

    @Query(value = "SELECT * FROM calves ORDER BY birth_weight DESC",nativeQuery = true)
    Optional<List<Calf>> sortByBirthWeightHeavy();

}
