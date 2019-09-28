//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;

//import androidx.cardview.widget.CardView;
//import androidx.recyclerview.widget.RecyclerView;

//import com.example.newproject.R;

//import java.util.Collections;
//import java.util.List;




//List<Data> data =new ArrayList<Data>();

//      RecyclerView recyclerview = new RecyclerView(getContext());
//      RecyclerViewAdapter adapter = new RecyclerViewAdapter (data);
//     recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
                //      recyclerview.setAdapter(adapter);
//  return recyclerview;

        // View view = null;
        //  view = inflater.inflate(R.layout.examplelayout, container, false);

        //  return view;}

//public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder>{

//    List<Data> list = Collections.emptyList();
//    Context context;

                //   public RecyclerViewAdapter (List<Data> list , Context context){

//    this.list = list ;
//    this.context = context ;
//    }

//  @Override
// public ViewHolder onCreateViewHolder (ViewGroup parent , int viewType);{

//      View view = LayoutInflater.from(getContext()).inflate(R.layout.user_list_row,parent, false);
//    ViewHolder holder = new ViewHolder(view);
                //    return holder;

//  }

//  @Override

//   public void onBindViewHolder (ViewHolder holder ,int position){





//  }



//}

// public class ViewHolder extends RecyclerView.ViewHolder{

// CardView cv;
//  ImageView imageview ;
//   TextView fname;
//   TextView lname;
//   TextView email;

//   public ViewHolder (View itemView){

//      super(itemView);

//      cv = (CardView) itemView.findViewById(R.id.cardview);
//      imageview = (ImageView) itemView.findViewById(R.id.avatar);
//     fname =(TextView) itemView.findViewById(R.id.firstname);
//     lname =(TextView) itemView.findViewById(R.id.lastname);
//     email =(TextView) itemView.findViewById(R.id.email);

//  }






//}

//public class Data {

//   public String fname;
//   public String lname;
//    public String email;
//    public int imageview;

//   Data (String fname,String lname ,String email,int imageview){

//       this.fname=fname;
//       this.lname=lname;
//       this.email=email;
//        this.imageview=imageview;
//    }

//}