package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TextField name;

    @FXML
    TextField phone;

    @FXML
    TextField email;

    @FXML
    ListView contactList;

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    public void onAdd() {
        Contact contact = new Contact(name.getText(), email.getText(), phone.getText());
        contacts.add(contact);
        name.clear();
        email.clear();
        phone.clear();
    }

    public void onRemove() {
        SelectionModel model = contactList.getSelectionModel();
        Contact contact = (Contact) model.getSelectedItem();
        contacts.remove(contact);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contactList.setItems(contacts);
    }
}
