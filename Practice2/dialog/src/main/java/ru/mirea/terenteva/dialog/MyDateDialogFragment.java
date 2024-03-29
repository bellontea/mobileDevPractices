package ru.mirea.terenteva.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class MyDateDialogFragment extends DialogFragment {
    Calendar dateAndTime= Calendar.getInstance();
    TextView date;

    public MyDateDialogFragment(TextView date)
    {
        this.date = date;
    }

    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.YEAR, year);
            setInitialDateTime();
        }
    };

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        return new DatePickerDialog(getActivity(), d, dateAndTime.get(Calendar.DAY_OF_MONTH),
                dateAndTime.get(Calendar.MONTH), dateAndTime.get(Calendar.YEAR));
    }
    private void setInitialDateTime() {

        date.setText(DateUtils.formatDateTime(getActivity(),
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR));
    }
}
