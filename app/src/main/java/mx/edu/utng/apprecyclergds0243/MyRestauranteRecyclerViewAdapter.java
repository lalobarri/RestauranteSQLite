package mx.edu.utng.apprecyclergds0243;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

//import mx.edu.utng.apprecyclergds0243.dummy.DummyContent.DummyItem;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Restaurante}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {

    private final List<Restaurante> mValues;
    private Context contexto;
    //Método constructor de la clase

    public MyRestauranteRecyclerViewAdapter(Context ctx, List<Restaurante> items) {
        contexto = ctx;  //Se define contexto
        mValues = items; //La lista de Restaurantes
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restaurante, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //Este método dibuja cada elemento de la lista
        holder.mItem = mValues.get(position);  //Rescatamos los datos de cada elemento
        holder.tvNombre.setText(holder.mItem.getNombre());
        holder.tvDireccion.setText(holder.mItem.getDireccion());
        holder.rbRestaurante.setRating(holder.rbRestaurante.getRating());
        //Para manejo de la imagen

        Glide.with(contexto)
                .load(holder.mItem.getUrlPhoto())
                .centerCrop()
                .placeholder(R.drawable.restaurante)
                .error(R.drawable.restaurante)
                .into(holder.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView; //Hace referencia al constraint layout
        public final TextView tvNombre;
        public final TextView tvDireccion;
        public final ImageView ivPhoto;
        public final RatingBar rbRestaurante;
        public Restaurante mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvNombre = (TextView) view.findViewById(R.id.tvNombre);
            tvDireccion = (TextView) view.findViewById(R.id.tvDireccion);
            ivPhoto = (ImageView)view.findViewById(R.id.ivPhoto);
            rbRestaurante = (RatingBar)view.findViewById(R.id.rbValoracion);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvNombre.getText() + "'";
        }
    }
}