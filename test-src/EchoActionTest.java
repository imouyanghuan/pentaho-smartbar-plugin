import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.pentaho.platform.api.engine.IPentahoSession;
import org.pentaho.platform.api.engine.IPlatformPlugin;
import org.pentaho.platform.api.engine.IPluginManager;
import org.pentaho.platform.api.engine.IPluginProvider;
import org.pentaho.platform.api.engine.IServiceManager;
import org.pentaho.platform.api.engine.ISolutionEngine;
import org.pentaho.platform.api.engine.PlatformPluginRegistrationException;
import org.pentaho.platform.api.engine.PluginBeanDefinition;
import org.pentaho.platform.api.engine.IPentahoDefinableObjectFactory.Scope;
import org.pentaho.platform.engine.core.system.StandaloneSession;
import org.pentaho.platform.engine.core.system.boot.PlatformInitializationException;
import org.pentaho.platform.engine.services.solution.SolutionEngine;
import org.pentaho.platform.engine.services.solution.SolutionHelper;
import org.pentaho.platform.plugin.services.pluginmgr.DefaultPluginManager;
import org.pentaho.platform.plugin.services.pluginmgr.PlatformPlugin;
import org.pentaho.platform.plugin.services.pluginmgr.PluginAdapter;
import org.pentaho.platform.plugin.services.pluginmgr.servicemgr.DefaultServiceManager;
import org.pentaho.test.platform.engine.core.MicroPlatform;

public class EchoActionTest {
  
  private MicroPlatform booter;

  StandaloneSession session;

  @Before
  public void init() {
    booter = new MicroPlatform("solutions");
    booter.define(ISolutionEngine.class, SolutionEngine.class, Scope.GLOBAL);
    booter.define(IServiceManager.class, DefaultServiceManager.class, Scope.GLOBAL);
    booter.define(IPluginManager.class, DefaultPluginManager.class, Scope.GLOBAL);
    booter.define("systemStartupSession", StandaloneSession.class, Scope.GLOBAL);

    session = new StandaloneSession();
  }
  
  @Test
  public void testEchoActionExecute() throws PlatformInitializationException, FileNotFoundException {
    booter.define(IPluginProvider.class, TestPluginProvider.class);
    booter.addLifecycleListener(new PluginAdapter());
    booter.start();
    
    OutputStream outputStream = new FileOutputStream(new File("testEchoActionExecute.html"));
    SolutionHelper.execute("testing EchoAction", "testuser", "bi-developers/EchoPlugin/echo.xaction", new HashMap(), outputStream);
    // TODO: add a convenience method in SolutionHelper to access the messages object
  }
  
  public static class TestPluginProvider implements IPluginProvider {
    public List<IPlatformPlugin> getPlugins(IPentahoSession session) throws PlatformPluginRegistrationException {
      PlatformPlugin p = new PlatformPlugin();
      p.setId("test-echoAction-plugin");
      p.addBean(new PluginBeanDefinition("EchoAction", "org.pentaho.samples.EchoAction"));
      return Arrays.asList((IPlatformPlugin) p);
    }
  }

}
