package id.ac.unp.ft.informatika.proyekdabble;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    private List<Question> questionList;
    private OnItemClickListener listener;

    // Interface untuk menangani klik pada item
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    // Konstruktor adapter
    public QuestionAdapter(List<Question> questionList) {
        this.questionList = questionList;
    }

    // Metode untuk mengatur listener klik item
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    // ViewHolder untuk menahan tampilan item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView questionTitleTextView;
        public TextView questionDescriptionTextView;

        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            questionTitleTextView = itemView.findViewById(R.id.questionTitleTextView);
            questionDescriptionTextView = itemView.findViewById(R.id.questionDescriptionTextView);

            // Set listener untuk menangani klik pada item
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    // Metode untuk membuat ViewHolder baru
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new ViewHolder(view, listener);
    }

    // Metode untuk mengikat data ke tampilan item
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Question question = questionList.get(position);
        holder.questionTitleTextView.setText(question.getTitle());
        holder.questionDescriptionTextView.setText(question.getDescription());
    }

    // Metode untuk mendapatkan jumlah item dalam daftar
    @Override
    public int getItemCount() {
        return questionList.size();
    }
}