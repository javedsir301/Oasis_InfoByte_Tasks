package com.example.todo.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todo.Model.Notes;

import java.util.List;

@androidx.room.Dao
public interface NotesDao {

    @Query("SELECT * FROM Notes_Database")
    LiveData<List<Notes>> getAllNotes();

//    Live<Notes>getAllNotes();

    @Insert
     void insertNotes(Notes... notes);

    @Query("DELETE FROM NOTES_DATABASE WHERE id = id")
    default void deleteNotes(int id) {

    }

    @Update
    void updateNotes(Notes notes);

}
