package typesafeconfig;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class DemoTest {

    @Test
    public void testPropertiesUsingParseResourcesAnySyntaxNoResolutionRequired() {
        Config config = ConfigFactory.parseResourcesAnySyntax("noresolution.properties");

        assertNotNull(config);
        assertFalse(config.isEmpty());
        assertTrue(config.isResolved());
    }

    @Test
    public void testPropertiesUsingParseResourcesAnySyntaxResolutionRequired() {
        Config config = ConfigFactory.parseResourcesAnySyntax("resolution.properties");

        assertNotNull(config);
        assertFalse(config.isEmpty());
        assertTrue(config.isResolved());

        Config resolvedConfig = config.resolve();

        assertNotNull(resolvedConfig);
        assertFalse(resolvedConfig.isEmpty());
        assertTrue(resolvedConfig.isResolved());

        assertEquals("3", resolvedConfig.getValue("four"));

    }

    @Test
    public void testConfUsingParseResourcesAnySyntaxNoResolutionRequired() {
        Config config = ConfigFactory.parseResourcesAnySyntax("noresolution.conf");
    
        assertNotNull(config);
        assertFalse(config.isEmpty());
        assertTrue(config.isResolved());
    }

    @Test
    public void testConfUsingParseResourcesAnySyntaxResolutionRequired() {
        Config config = ConfigFactory.parseResourcesAnySyntax("resolution.conf");
    
        assertNotNull(config);
        assertFalse(config.isEmpty());
        assertFalse(config.isResolved());
    
        Config resolvedConfig = config.resolve();
    
        assertNotNull(resolvedConfig);
        assertFalse(resolvedConfig.isEmpty());
        assertTrue(resolvedConfig.isResolved());
    
        assertEquals("3", resolvedConfig.getString("four"));
    
    }

}
