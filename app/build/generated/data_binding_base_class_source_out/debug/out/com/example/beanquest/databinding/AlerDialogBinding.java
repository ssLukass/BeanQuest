// Generated by view binder compiler. Do not edit!
package com.example.beanquest.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.beanquest.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AlerDialogBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final AppCompatButton btnCansel;

  @NonNull
  public final AppCompatButton btnYes;

  private AlerDialogBinding(@NonNull CardView rootView, @NonNull AppCompatButton btnCansel,
      @NonNull AppCompatButton btnYes) {
    this.rootView = rootView;
    this.btnCansel = btnCansel;
    this.btnYes = btnYes;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static AlerDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AlerDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.aler_dialog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AlerDialogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_cansel;
      AppCompatButton btnCansel = ViewBindings.findChildViewById(rootView, id);
      if (btnCansel == null) {
        break missingId;
      }

      id = R.id.btn_yes;
      AppCompatButton btnYes = ViewBindings.findChildViewById(rootView, id);
      if (btnYes == null) {
        break missingId;
      }

      return new AlerDialogBinding((CardView) rootView, btnCansel, btnYes);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
