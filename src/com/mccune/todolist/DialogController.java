package com.mccune.todolist;
import com.mccune.todolist.datamodel.TodoData;
import com.mccune.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField shortDescriptionField;

    @FXML
    private TextArea detailsArea;

    @FXML
    private DatePicker deadlinePicker;


    public TodoItem processResults(){
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        TodoItem newItem = new TodoItem(shortDescription,details,deadlineValue);
//        TodoData.getInstance().addTodoItem(newItem);
        return newItem;

    }

    public void editItem(TodoItem item){
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        item.setShortDescription(shortDescription);
        item.setDetials(details);
        item.setDeadline(deadlineValue);


    }

    public void populateCurrentItem(TodoItem item){
        detailsArea.setText(item.getDetials());
        shortDescriptionField.setText(item.getShortDescription());
        deadlinePicker.setValue(item.getDeadline());

    }

}
