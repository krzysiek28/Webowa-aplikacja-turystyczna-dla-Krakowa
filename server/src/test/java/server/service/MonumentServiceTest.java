package server.service;

import org.mockito.Mock;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import server.monument.MonumentEntity;
import server.monument.MonumentRepository;
import server.monument.MonumentService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class MonumentServiceTest {

    private MonumentService testedObject;

    @Mock
    private MonumentRepository mockedMonumentRepository;

    @BeforeTest
    public void setTestedObject(){
        initMocks(this);
        testedObject = new MonumentService(mockedMonumentRepository);
    }

    @Test
    public void shouldAddMonument(){
//        MonumentEntity monument = new MonumentEntity("testName", "testKind", "testDescription", "testCoordinate", 10, "testOpeningHours");
//        MonumentEntity secondMonument = new MonumentEntity("testName2", "testKind2", "testDescription2", "testCoordinate2", 5, "testOpeningHours2");
//        mockedMonumentRepository.save(monument);
//        mockedMonumentRepository.save(secondMonument);
//        List<MonumentEntity> monumentList = new ArrayList<>();
//        monumentList.add(monument);
//        monumentList.add(secondMonument);
//        assertEquals(mockedMonumentRepository.findAll(), monumentList);
    }
}
