package edu.cnm.deepdive.attendance.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import java.util.Date;

@Entity(
    tableName = "absences",
    foreignKeys = {
        @ForeignKey(
            entity = Student.class,
            parentColumns = "student_id",
            childColumns = "student_id",
            onDelete = ForeignKey.CASCADE
        )
    },
    indices = {
        @Index(value = {"start_date", "end_date"}),
        @Index(value = {"student_id", "start_date"}, unique = true),
        @Index(value = {"student_id", "start", "end"})
    }
)
public class Absence {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "absence_id")
  private long id;

  @ColumnInfo(name = "student_id", index = true)
  private long studentId;

  @NonNull
  private Date startDate = new Date();

  private Date endDate;

  private boolean excused;

  public long getId() {
    return id;
  }

  public void setId(long absId) {
    this.id = absId;
  }

  public long getStudentId() {
    return studentId;
  }

  public void setStudentId(long studId) {
    this.studentId = studId;
  }

  @NonNull
  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(@NonNull Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public boolean isExcused() {
    return excused;
  }

  public void setExcused(boolean excused) {
    this.excused = excused;
  }
}
