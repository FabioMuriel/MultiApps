package com.example.androidmaster.todoapp

sealed class TaskCategory(var isSelectd: Boolean = true) {
    object Personal : TaskCategory();
    object Business : TaskCategory();
    object Other : TaskCategory();
}