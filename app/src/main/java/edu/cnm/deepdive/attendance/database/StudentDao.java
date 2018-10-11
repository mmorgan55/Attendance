package edu.cnm.deepdive.attendance.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;

@Dao
public interface StudentDao {

  @Insert(onConflict = OnConflictStrategy.FAIL)
  long insert(Student student);

  @Insert(onConflict = OnConflictStrategy.FAIL)
  List<Long> insert(Student... students);

  @Insert(onConflict = OnConflictStrategy.FAIL)
  List<Long> insert(List<Student> students);

  @Query("SELECT * FROM students ORDER BY last_name, first_name")
  List<Student> select();

  @Query("SELECT * FROM students "
      + "WHERE last_name LIKE :pattern OR first_name LIKE :pattern OR display_name "
      + "LIKE :pattern ORDER BY last_name ASC, first_name ASC")
  List<Student> select (String pattern);

  @Update(onConflict = OnConflictStrategy.FAIL)
  int update(Student student);

  @Update(onConflict = OnConflictStrategy.FAIL)
  int update(Student...student);

  @Update(onConflict = OnConflictStrategy.FAIL)
  int update(List<Student> student);

  @Delete
  int delete(Student student);

  @Delete
  int delete(Student...student);

  @Delete
  int delete(List<Student> student);
}
