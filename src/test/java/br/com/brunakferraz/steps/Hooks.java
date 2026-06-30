package br.com.brunakferraz.steps;

import br.com.brunakferraz.base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class Hooks extends BaseTest {

    @BeforeEach
    public void before() throws Exception {
        setUp();
    }

    @AfterEach
    public void after() {
        tearDown();
    }
}