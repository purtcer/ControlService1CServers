package ServersSettings;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

public class ServersTableModel extends AbstractTableModel {

    private String[] columns = {"Версия 1С", "Компьютер", "Порт"};
    private Vector data = new Vector();

    public ServersTableModel(Vector serversList){
        data.clear();
        int sizeServersList = serversList.size();
        for (int i = 0; i < sizeServersList; i++) {
            addRowTable((Object[])serversList.get(i));
        }
    }

    public ServersTableModel(){

    }

    public void addRowTable(Object[] rowServer){
        data.add(rowServer);
    }

    public void deleteRowTable(int rowIndex){
        data.remove(rowIndex);
    }

    public Vector getTableData(){
        return data;
    }

    public int getRowCount() {
        return data.size();
    }

    public int getColumnCount() {
        return columns.length;
    }

    public Object getValueAt(int i, int i1) {
        Object[] rowData = (Object[])(data.get(i));
        return rowData[i1];
    }

    public String getColumnName(int col) {
        return columns[col];
    }

}
