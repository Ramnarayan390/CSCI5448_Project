package views;
 
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
 
public class TableExample extends JFrame
{
    public TableExample()
    {
        //headers for the table
        String[] columns = new String[] {
            "Id", "Name", "Verify"
        };
         
        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
            {"1", "John", false },
            {"2", "Rambo", false },
            {"3", "Zorro", false },
        };
         
        final Class[] columnClass = new Class[] {
            String.class, String.class, Boolean.class
        };
 
        //create table model with data
        DefaultTableModel model = new DefaultTableModel(data, columns) {
 
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return true;
            }
 
            @Override
            public Class<?> getColumnClass(int columnIndex)
            {
                return columnClass[columnIndex];
            }
        };
         
        JTable table = new JTable(model);
         
        //add the table to the frame
        this.add(new JScrollPane(table));
         
        this.setTitle("Table 	");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
    }
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TableExample();
            }
        });
    }   
}