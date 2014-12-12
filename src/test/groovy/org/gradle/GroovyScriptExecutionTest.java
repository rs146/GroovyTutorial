package org.gradle;

import static org.junit.Assert.assertTrue;
import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for executing a Groovy script {@code HelloName.groovy}.
 *
 * @author rahulsingh
 */
public class GroovyScriptExecutionTest {

    private static final String TEST_NAME = "Rahul Singh";
    private static final String GROOVY_SCRIPTS_LOCATION = "src/main/resources/scripts";
    private static final String OUTPUT_FILE_NAME = "output.txt";

    /**
     * We will execute the Groovy script before the unit tests on it's output.
     */
    @Before
    public void setUp() {
        String[] roots = new String[] { GROOVY_SCRIPTS_LOCATION };
        GroovyScriptEngine gse = null;
        try {
            gse = new GroovyScriptEngine(roots);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Binding binding = new Binding();
        binding.setVariable("name", TEST_NAME);
        binding.setVariable("base", roots[0]);
        binding.setVariable("outputFile", OUTPUT_FILE_NAME);
        try {
            gse.run("HelloName.groovy", binding);
        } catch (ResourceException | ScriptException e) {
            e.printStackTrace();
        }
    }

    /**
     * Now we can test the output produced by the Groovy script.
     */
    @Test
    public void testHelloNameGroovyScript() {
        try {
            Path path = Paths.get(GROOVY_SCRIPTS_LOCATION + File.separator + OUTPUT_FILE_NAME);
            List<String> lines =  Files.readAllLines(path, Charset.defaultCharset());

            assertTrue(lines.stream()
                    .allMatch(str -> 
                             str.equals("Hello there " + TEST_NAME)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
