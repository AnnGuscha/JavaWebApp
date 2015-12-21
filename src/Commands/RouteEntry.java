package Commands;

import Controllers.IController;

/**
 * Created by Anna on 12/21/2015.
 */
public class RouteEntry {
    String pattern;
    int role;
    IController controller;

    public RouteEntry(String pattern, int role, IController controller) {
        this.pattern = pattern;
        this.role = role;
        this.controller = controller;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public IController getController() {
        return controller;
    }

    public void setController(IController controller) {
        this.controller = controller;
    }
}
