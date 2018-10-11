package edu.cnm.deepdive.attendance.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Update;
import java.util.List;

@Dao
public interface AbsenceDao {

  @Insert(onConflict = OnConflictStrategy.FAIL)
  long insert(Absence absence);

  @Insert(onConflict = OnConflictStrategy.FAIL)
  List<Long> insert(Absence... absence);

  @Insert(onConflict = OnConflictStrategy.FAIL)
  List<Long> insert(List<Absence> absence);

  @Update(onConflict = OnConflictStrategy.FAIL)
  int update(Absence absence);

  @Update(onConflict = OnConflictStrategy.FAIL)
  int update(Absence... absence);

  @Update(onConflict = OnConflictStrategy.FAIL)
  int update(List<Absence> absence);

  @Delete
  int delete (Absence absence);

  @Delete
  int delete (Absence... absence);

  @Delete
  int delete (List<Absence> absence);
}
