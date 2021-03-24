package fr.esiea.ex4A;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatchTest {

    @Test
    void getName(){
        MatchesData matchesData = new MatchesData("Leo","Amscray");
        Assertions.assertEquals("Leo",matchesData.getName());
    }

    @Test
    void getTwitter(){
        MatchesData matchesData = new MatchesData("Leo", "Amscray");
        Assertions.assertEquals("Amscray", matchesData.getTwitter());
    }

}
