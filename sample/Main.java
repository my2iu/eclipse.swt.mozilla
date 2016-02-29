import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Main
{
   public static void main(String [] args)
   {
      System.setProperty("org.eclipse.swt.browser.XULRunnerPath", new File("xulrunner-sdk/bin").getAbsolutePath());
      System.setProperty("org.eclipse.swt.browser.MOZ_PROFILE_PATH", new File("mozProfile/").getAbsolutePath());
      Display display = new Display();
      Shell shell = new Shell(display);
      shell.setLayout(new FillLayout());
      Browser browser = new Browser(shell, SWT.MOZILLA);
      browser.setUrl("https://chromium.github.io/octane/");
      shell.open();
      while (!shell.isDisposed())
      {
         if (!display.readAndDispatch())
            display.sleep();
      }
      display.dispose();
   }
}
