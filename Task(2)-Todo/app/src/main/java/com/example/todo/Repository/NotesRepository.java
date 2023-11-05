package com.example.todo.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.todo.Dao.NotesDao;
import com.example.todo.Database.NotesDatabase;
import com.example.todo.Model.Notes;

import java.util.List;

public class NotesRepository {
    public NotesDao notesDao;
    public LiveData<List<Notes>> getAllNotes;


    public NotesRepository(Application application) {
        NotesDatabase database = NotesDatabase.getDatabaseInstance(application);
        notesDao = database.notesDao();
        getAllNotes = notesDao.getAllNotes();
    }

    public void insertNotes(Notes notes) {
        notesDao.insertNotes(notes);
    }

     public void deleteNotes(int id) {
        notesDao.deleteNotes(id);
    }

   public void updateNotes(Notes notes) {
        notesDao.updateNotes(notes);
    }

}