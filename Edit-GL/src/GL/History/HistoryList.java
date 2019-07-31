package GL.History;

import GL.Object.History;

import java.util.ArrayList;
import java.util.List;

//====================== HistoryList Class ========================//
public class HistoryList{
    private List<History> histories = new ArrayList<>();

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }
}
