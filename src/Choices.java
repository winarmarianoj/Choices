import controller.Controller;
import controller.WindowController;
import ui.Window;
import ui.panels.MainPanel;

public class Choices {
    public static void main(String[] args) throws Exception {
        Window window = new Window("THE FINDING GAME OF THE WORD", new MainPanel());
        Controller controller = new WindowController(window);
    }
}
