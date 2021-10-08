package com.example.demo.view
import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.scene.control.SelectionMode
import javafx.scene.control.TextField
import jdk.nashorn.internal.objects.Global
import tornadofx.*
import kotlin.properties.Delegates
//Main Activity
//Initializing the array lists
class MainView: View() {
    var itemlist = arrayListOf<String>().asObservable()
    lateinit var taskfield : TextField
    override val root = vbox {
        vbox{
            listview(itemlist) {
                selectionModel.selectionMode = SelectionMode.MULTIPLE
                //On double-click. the selected item will be deleted
            onUserSelect(2){
                itemlist.remove(selectedItem)
            }
            }
        }
        hbox {

            textfield() {
                taskfield = this
            }// Adding the task when the button is pressed
            //when input will be added text space will be cleared.
            button("ADD TASK"){
                action {
                    itemlist.add(taskfield.text)
                    taskfield.clear()
                }
            }
        }

    }

}
