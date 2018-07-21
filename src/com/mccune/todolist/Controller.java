package com.mccune.todolist;

import com.mccune.todolist.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<TodoItem> todoItems;

    @FXML
    private ListView<TodoItem> todoListView;

    @FXML
    private TextArea itemDetialsTextArea;

    @FXML
    private Label deadlineLabel;

    public void initialize(){
        TodoItem item1 = new TodoItem("Mail birthday card","Buy a 30th birthday card for John", LocalDate.of(2018, Month.DECEMBER,25));
        TodoItem item2 = new TodoItem("Doctor's Appointment","See Dr.Smith 123 Main Street. Bring paperwork.", LocalDate.of(2018, Month.OCTOBER,30));
        TodoItem item3 = new TodoItem("Finish Design Proposal","Email Mike by Friday 22nd", LocalDate.of(2018, Month.SEPTEMBER,22));
        TodoItem item4 = new TodoItem("Pickup Doug at the train station","Go get Doug on March 23rd", LocalDate.of(2018, Month.MARCH,23));
        TodoItem item5 = new TodoItem("Pick up drycleaning","The clothes should be ready Wednesday.", LocalDate.of(2018, Month.JULY,25));

        todoItems = new ArrayList<TodoItem>();

        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

        // rather than listening for mouse clicks, we listen for selection changes. This allows us to select the first item of the todoList programmatically in our init method and still have the details populate.

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) {
                if(newValue != null){
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetialsTextArea.setText(item.getDetials());
                    // by using a date formatter we can put the date in a way that is easier to read. 
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    deadlineLabel.setText(df.format(item.getDeadline()));

                }

            }
        });

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        todoListView.getSelectionModel().selectFirst();



    }

    @FXML
    public void handleClickListView(){
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        itemDetialsTextArea.setText(item.getDetials());
        deadlineLabel.setText(item.getDeadline().toString());


//        System.out.println("The selected item is " + item);
//        StringBuilder sb = new StringBuilder(item.getDetials());
//        sb.append("\n\n\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadline().toString());
//        itemDetialsTextArea.setText(sb.toString());

    }
}
