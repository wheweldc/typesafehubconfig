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
    public void testUsingParseResourcesAnySyntaxNoResolutionRequired() {
        Config config = ConfigFactory.parseResourcesAnySyntax("noresolution.properties");

        assertNotNull(config);
        assertFalse(config.isEmpty());
        assertTrue(config.isResolved());
    }

    @Test
    public void testUsingParseResourcesAnySyntaxResolutionRequired() {
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

}
