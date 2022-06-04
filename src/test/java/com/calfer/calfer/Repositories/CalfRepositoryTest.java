package com.calfer.calfer.Repositories;
import com.calfer.calfer.Models.Calf;
import com.calfer.calfer.Utils.CalfSex;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CalfRepositoryTest {


    @Autowired
    private CalfRepository underTest;


    @Test
    public void saveCalfId(){
        //GIVEN
        String EXPECTED_TAG_NUMBER="ANOTHER ONE";
        Calf calf = new Calf(EXPECTED_TAG_NUMBER,"",new Date(),33, CalfSex.BULL);

        //WHEN
        underTest.save(calf);
        Calf foundCalf = underTest.findById(1l).get();

        //THEN
        assertThat(foundCalf.getTagNumber()).isEqualTo(EXPECTED_TAG_NUMBER);


    }

    @Test
    public void findByTagNumberTest(){
        //GIVEN
        String EXPECTED_TAG_NUMBER="ANOTHER ONE";
        Calf calf = new Calf(EXPECTED_TAG_NUMBER,"",new Date(),33, CalfSex.BULL);

        //WHEN
        underTest.save(calf);
        Calf foundCalf = underTest.findByTagNumber(EXPECTED_TAG_NUMBER).get();


        //THEN
        assertThat(foundCalf.getTagNumber()).isEqualTo(EXPECTED_TAG_NUMBER);

    }

    @Test
    public void findAllCalvesBySex(){
        //GIVEN
        CalfSex EXPECTED_SEX = CalfSex.BULL;
        Calf calf = new Calf("FDSAF43","",new Date(),33, EXPECTED_SEX);
        Calf calf2 = new Calf("FDSdAF43","",new Date(),33, EXPECTED_SEX);

        //WHEN
        underTest.save(calf);
        underTest.save(calf2);

        List<Calf> bulls = underTest.findAllCalvesBySex(CalfSex.BULL.name()).get();

        //THEN
        //assertThat(foundCalf.getCalfSex()).isEqualTo(EXPECTED_SEX);
        assertThat(bulls.size()).isEqualTo(2);
    }

    @Test
    public void sortByBirthWeightTest(){
        //GIVEN
        Integer EXPECTED_WEIGHT = 44;
        Calf calf = new Calf("FDSAF43","",new Date(),EXPECTED_WEIGHT, CalfSex.BULL);
        Calf calf2 = new Calf("FDSdAF43","",new Date(),33, CalfSex.BULL);

        //WHEN
        underTest.save(calf);
        underTest.save(calf2);
        List<Calf> calfList = underTest.sortByBirthWeightHeavy().get();

        //THEN
        assertThat(calfList.get(0).getBirthWeight()).isEqualTo(EXPECTED_WEIGHT);

    }

}
