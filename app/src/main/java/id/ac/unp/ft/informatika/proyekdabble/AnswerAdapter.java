package id.ac.unp.ft.informatika.proyekdabble;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.ViewHolder> {

    private List<Answer> answerList;

    // Konstruktor adapter
    public AnswerAdapter(List<Answer> answerList) {
        this.answerList = answerList;
    }

    // ViewHolder untuk menahan tampilan item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView answerContentTextView;
        public TextView answerAuthorTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            answerContentTextView = itemView.findViewById(R.id.answerContentTextView);
            answerAuthorTextView = itemView.findViewById(R.id.answerAuthorTextView);
        }
    }

    // Metode untuk membuat ViewHolder baru
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_answer, parent, false);
        return new ViewHolder(view);
    }

    // Metode untuk mengikat data ke tampilan item
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Answer answer = answerList.get(position);
        holder.answerContentTextView.setText(answer.getContent());
        holder.answerAuthorTextView.setText("by " + answer.getAuthor());
    }

    // Metode untuk mendapatkan jumlah item dalam daftar
    @Override
    public int getItemCount() {
        return answerList.size();
    }
}