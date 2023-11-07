import React, { useState } from "react";
import "./App.css";

function ToDoList() {
  const [inputList, setinputList] = useState("");
  const [todoItems, settodoItems] = useState([]);
  const [editTodo, setEditTodo] = useState({ text: "", index: null });

  const itemEvent = (e) => {
    setinputList(e.target.value);
  };

  const addTodo = () => {
    settodoItems((oldItem) => {
      return [...oldItem, inputList];
    });
    setinputList("");
  };

  const deleteTodo = (index) => {
    const updatedTodo = todoItems.filter((_, i) => i !== index);
    settodoItems(updatedTodo);
  };

  const editTodoHandler = (index) => {
    const textToEdit = todoItems[index];
    setEditTodo({ text: textToEdit, index });
  };

  const saveEditedItem = () => {
    const updatedItems = [...todoItems];
    updatedItems[editTodo.index] = editTodo.text;
    settodoItems(updatedItems);
    setEditTodo({ text: "", index: null });
  };

  return (
    <div className="main-div">
      <div className="container">
        <div className="todo">
          <h1>ToDo List</h1>
          <input
            type="text"
            className="todo-input"
            placeholder="Add ToDo"
            value={inputList}
            onChange={itemEvent}
          />
          <button onClick={addTodo}> + </button>
          <ul>
            {todoItems.map((itemVal, index) => {
              return (
                <div key={index} className="tododiv">
                  {editTodo.index === index ? (
                    <div className="edit-block">
                      <input
                        type="text"
                        className="edited-item"
                        value={editTodo.text}
                        onChange={(e) =>
                          setEditTodo({ text: e.target.value, index })
                        }
                      ></input>
                      <button onClick={saveEditedItem} className="save-btn">
                        Save
                      </button>
                    </div>
                  ) : (
                    <li> {itemVal} </li>
                  )}
                  <div className="btns">
                    <button
                      className="deletebtn"
                      onClick={() => {
                        deleteTodo(index);
                      }}
                    >
                      Delete
                    </button>

                    {/* Edit Button */}
                    <button
                      onClick={() => editTodoHandler(index)}
                      className="edit-btn"
                      style={{
                        padding: "10px 21px",
                        borderRadius: "20px",
                        marginLeft: "20px",
                      }}
                    >
                      Edit
                    </button>
                  </div>
                </div>
              );
            })}
          </ul>
        </div>
      </div>
    </div>
  );
}

export default ToDoList;
