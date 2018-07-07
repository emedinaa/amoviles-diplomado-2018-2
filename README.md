# amoviles-diplomado-2018-2
Curso de Aplicaciones Android con Java - Diplomado 2018 II - Academia Móviles 

## Lesson 4 - Saturday, 7th July, 2018

- Review

- Lesson

- Samples

- Homework

- Resources

## Review

### ¿Qué temas vimos en la clase pasada ?

- Adapters, Custom Adapters
- ListView,GridView , RecyclerView
- Java Collections

### Activities

- Completemos los ejemplos de la clase anterior , AdapterSamples https://github.com/emedinaa/amoviles-diplomado-2018-2/tree/Lesson3-adapter-recyclerview

- Hagamos una lista de productos , para lo cual deben de crear los siguiente:

    - Una entidad llamada Product
    - Una celda en xml, ustedes decidan que parámetros van a mostrar
    - Crear un custom adapter
    - Mostrar la lista con los productos cargados
    - Pueden encontrar imágenes para los productos en iconfinder.com https://www.iconfinder.com/search/?q=products&price=free
    
- ¿Dónde lanzar los eventos en las listas ? 

<img src="https://github.com/learning-android-pe/training-resources/blob/master/ui/adapter-events-I.png?raw=true" height="480"/>

<img src="https://github.com/learning-android-pe/training-resources/blob/master/ui/adapter-events-II.png?raw=true" height="480"/>

## Lesson

• Conocer el uso de Fragment

• Implementar Frament dinámicos o estáticos

• Objetos de Navegación

• Interfaz de usuario (pestanas / Tabs)

• Gestión de Preferencia (Sharedpreferences)

• Android permission system

• Tareas en segundo plano - AsyncTask

• Conocer las características de la base de datos
con Sqlite

• Desarrollar aplicaciones Android haciendo uso
de la base de datos

• Inserción, actualización y eliminación de
registros (CRUD)

### Fragments, conceptos y comunicación.

- Fragments

- Creating a Fragment

- Fragment Lifecycle

- Communicating with the Activity

- Communication between Fragments

- Exercises

### Conociendo los Fragments

Los fragmentos son vistas con código y diseño(XML) , no necesitan ser registrados en el AndroidManifest y requieren de una actividad como contenedor. Se pueden agregar o quitar a demanda  y tambien cuentan con su propio ciclo de vida. 
Adicional, una actividad puede contener más de un fragment, es decir , por ejemplo, en una pantalla puede tener 2 fragments.
Los fragments se usan para construir componentes reusables, evitando duplicación de recursos y de código , además se usa mucho cuando es requerido que una aplicación funcione tanto en un smartphone y tablets.

![fragments](https://developer.android.com/images/training/basics/fragments-screen-mock.png)

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson6/images/fragments03.png?raw=true" height="480"/>

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson6/images/fragments04.png?raw=true" height="480"/>

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson6/images/fragments05.png?raw=true" height="480"/>


### Creando un Fragment

<img src="https://github.com/learning-android-pe/training-resources/blob/master/fragments.png?raw=true" height="480"/>

```java
    import android.os.Bundle;
    import android.support.v4.app.Fragment;
    import android.view.LayoutInflater;
    import android.view.ViewGroup;

    public class ArticleFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.article_view, container, false);
        }
    }
```

Una vez creado un fragment, este puede ser insertado como cualquier componente de diseño 

```xml
  <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
      android:orientation="horizontal"
      android:layout_width="fill_parent"
      android:layout_height="fill_parent">

      <fragment android:name="com.example.android.fragments.HeadlinesFragment"
                android:id="@+id/headlines_fragment"
                android:layout_weight="1"
                android:layout_width="0dp"
                android:layout_height="match_parent" />

      <fragment android:name="com.example.android.fragments.ArticleFragment"
                android:id="@+id/article_fragment"
                android:layout_weight="2"
                android:layout_width="0dp"
                android:layout_height="match_parent" />

</LinearLayout>

```

Para poder insertar el Fragment en un activity por programación

```java
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            HeadlinesFragment firstFragment = new HeadlinesFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }
}
```

Otra opción podría ser reemplazar un fragment por otro , para lo cual :

```java
  // Create fragment and give it an argument specifying the article it should show
  ArticleFragment newFragment = new ArticleFragment();
  Bundle args = new Bundle();
  args.putInt(ArticleFragment.ARG_POSITION, position);
  newFragment.setArguments(args);

  FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

  // Replace whatever is in the fragment_container view with this fragment,
  // and add the transaction to the back stack so the user can navigate back
  transaction.replace(R.id.fragment_container, newFragment);
  transaction.addToBackStack(null);

  // Commit the transaction
  transaction.commit();
```

### Ciclo de un vida de un Fragment

![fragments](https://developer.android.com/guide/components/images/activity_lifecycle.png)

### Comunicación 

Para poder comunicar un fragment con una actividad(padre) o con otro fragment , usamos interfaces como canal de comunicación

```java
    public class HeadlinesFragment extends ListFragment {
        OnHeadlineSelectedListener mCallback;

        // Container Activity must implement this interface
        public interface OnHeadlineSelectedListener {
            public void onArticleSelected(int position);
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);

            // This makes sure that the container activity has implemented
            // the callback interface. If not, it throws an exception
            try {
                mCallback = (OnHeadlineSelectedListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString()
                        + " must implement OnHeadlineSelectedListener");
            }
        }

        ...
    }
```

La interface puede ser creada de manera independiente o asociada a una actividad con la que se requiere comunicarse

```java
  public static class MainActivity extends Activity
          implements HeadlinesFragment.OnHeadlineSelectedListener{
      ...

      public void onArticleSelected(int position) {
          // The user selected the headline of an article from the HeadlinesFragment
          // Do something here to display that article
      }
  }

```

Enviar parámetros a un Fragment, para lo cual usamos la clase "Bundle"

```java
public static class MainActivity extends Activity
        implements HeadlinesFragment.OnHeadlineSelectedListener{
    ...

    public void onArticleSelected(int position) {
        // The user selected the headline of an article from the HeadlinesFragment
        // Do something here to display that article

        ArticleFragment articleFrag = (ArticleFragment)
                getSupportFragmentManager().findFragmentById(R.id.article_fragment);

        if (articleFrag != null) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            articleFrag.updateArticleView(position);
        } else {
            // Otherwise, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected article
            ArticleFragment newFragment = new ArticleFragment();
            Bundle args = new Bundle();
            args.putInt(ArticleFragment.ARG_POSITION, position);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }
}
```
Comunicación Activity con Fragment

<img src="https://github.com/learning-android-pe/training-resources/blob/master/fragments-communication1.png?raw=true" height="480"/>

Comunicación Fragment con Activity

<img src="https://github.com/learning-android-pe/training-resources/blob/master/fragments-communication2.png?raw=true" height="480"/>

Comunicación Fragment con Fragment

<img src="https://github.com/learning-android-pe/training-resources/blob/master/fragments-communication3.png?raw=true" height="480"/>

## Storage Options

- (en)https://developer.android.com/guide/topics/data/data-storage
- (es)https://developer.android.com/guide/topics/data/data-storage?hl=es-419

## DB Sqlite

Otra forma de persistir información es usando una base de datos local (SQLITE), donde puedes usar el lenguaje SQL y realizar las operaciones que necesites para manejar una BD en tu APP.

Lo primero, es crear una BD, donde definimos el nombre y versión, asi como las tablas

```java
package com.belatrix.kotlintemplate.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
 
    public static final String DATABASE_NAME = "BDNote";
 
    public static final String TABLE_NOTES = "tb_notes";
    
    //Columnas de la Tabla Notes
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_DESC = "desc";
    public static final String KEY_PATH = "path";
    
    
    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql= "CREATE TABLE " + TABLE_NOTES + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + KEY_NAME + " TEXT,"
                + KEY_DESC + " TEXT,"
                + KEY_PATH + " TEXT" + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        String sql= "DROP TABLE IF EXISTS " + TABLE_NOTES;
        db.execSQL(sql);
    }

}
```
Con la BD creada , requerimos definir una entidad que represente a un de las tablas y otra clase para manejar las operaciones sobre ella (CRUD)

Entidad :

```java
public class NoteEntity implements Serializable {

    private int id;
    private String name;
    private String description;
    private String path;

    public NoteEntity() {
    }

    public NoteEntity(int id, String name, String description, String path) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.path = path;
    }

    public NoteEntity(String name, String description, String path) {
        this.name = name;
        this.description = description;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "NoteEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
```

Operaciones (CRUD)

```java
public class CRUDOperations {

    private MyDatabase helper;
    public CRUDOperations(SQLiteOpenHelper _helper) {
        super();
        // TODO Auto-generated constructor stub
        helper =(MyDatabase)_helper;
}
...
```

Por ejemplo, para agregar un registro

```java
  public void addNote(NoteEntity noteEntity)
    {
       SQLiteDatabase db = helper.getWritableDatabase(); //modo escritura
       ContentValues values = new ContentValues();
       values.put(MyDatabase.KEY_NAME, noteEntity.getName());
       values.put(MyDatabase.KEY_DESC, noteEntity.getDescription());
       values.put(MyDatabase.KEY_PATH, noteEntity.getPath());

       db.insert(MyDatabase.TABLE_NOTES, null, values);
       db.close();
  }
```

Editar un registro

```java
public int updateNote(NoteEntity noteEntity)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MyDatabase.KEY_NAME, noteEntity.getName());
        values.put(MyDatabase.KEY_DESC, noteEntity.getDescription());
        values.put(MyDatabase.KEY_PATH, noteEntity.getPath());

        int row =db.update(MyDatabase.TABLE_NOTES,
                values,
                MyDatabase.KEY_ID+"=?",
                new String[]{String.valueOf(noteEntity.getId())});
        db.close();

        return row;
}
```

Obtener un registro
```java
public NoteEntity getNote(int id)
    {
        SQLiteDatabase db = helper.getReadableDatabase(); //modo lectura
        Cursor cursor = db.query(MyDatabase.TABLE_NOTES,
                new String[]{MyDatabase.KEY_ID, MyDatabase.KEY_NAME,
                        MyDatabase.KEY_DESC, MyDatabase.KEY_PATH},
                MyDatabase.KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
        }
        int nid = Integer.parseInt(cursor.getString(0));
        String name = cursor.getString(1);
        String desc = cursor.getString(2);
        String path = cursor.getString(3);

        NoteEntity noteEntity= new NoteEntity(
                nid, name, desc,path);
        db.close();
        return noteEntity;
}
```

Obtener todos los registros

```java
public List<NoteEntity> getAllNotes()
    {
        List<NoteEntity> lst =new ArrayList<NoteEntity>();
        String sql= "SELECT  * FROM " + MyDatabase.TABLE_NOTES;
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst())
        {
            do
            {
                NoteEntity contact =new NoteEntity();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setDescription(cursor.getString(2));
                contact.setPath(cursor.getString(3));

                lst.add(contact);
            }while(cursor.moveToNext());
        }
        db.close();
        return lst;
}
```

Borrar un registro

```java
  public int deleteNote(NoteEntity noteEntity)
    {
       SQLiteDatabase db = helper.getWritableDatabase(); 
       int row= db.delete(MyDatabase.TABLE_NOTES,
           MyDatabase.KEY_ID+"=?", 
           new String[]{String.valueOf(noteEntity.getId())});
       db.close();
      return row;
  }
```

## SharedPreferences

- Inicializar SharedPreferences

```java
Context context = getActivity();
SharedPreferences sharedPref = context.getSharedPreferences(
        getString(R.string.preference_file_key), Context.MODE_PRIVATE);
```
- Guardar un valor

```java
SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPref.edit();
editor.putInt(getString(R.string.saved_high_score_key), newHighScore);
editor.commit();
```

- Obtener un valor
```java
SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
int defaultValue = getResources().getInteger(R.integer.saved_high_score_default_key);
int highScore = sharedPref.getInt(getString(R.string.saved_high_score_key), defaultValue);
```

## Samples

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson6/exercises/Exercise1.png?raw=true" height="320"/> <img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson6/exercises/Exercise2.png?raw=true" height="320"/>

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson6/exercises/Exercise3.png?raw=true" height="320"/> <img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson6/exercises/Exercise5.png" height="320"/>

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson6/exercises/screenshot_color.png?raw=true" height="320"/> <img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson6/exercises/screenshot_contacts.png?raw=true" height="320"/>

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson6/exercises/screenshot_message.png?raw=true" height="320"/> <img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson6/exercises/screenshot_tab.png?raw=true" height="320"/>

- FragmentSamples
<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson7/images/fragment_samples.png?raw=true" height="480"/>

- NavigationSamples
<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson7/images/navigation_samples.png?raw=true" height="480"/>

- DBSamples
<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson7/images/db_samples.png?raw=true" height="480"/>

## Homework

- Realizar los ejercicios  01, 02 sobre Fragments

## Resources 

- Fragment https://developer.android.com/reference/android/app/Fragment.html

- Developer Guides : Fragments https://developer.android.com/guide/components/fragments.html

- Building a Dynamic UI with Fragments https://developer.android.com/training/basics/fragments/index.html

- Storage Options https://developer.android.com/guide/topics/data/data-storage.html

- Save Data using SQLite https://developer.android.com/training/data-storage/sqlite.html

- Saving data in local database using Room https://developer.android.com/training/data-storage/room/index.html

- ORMLite http://ormlite.com/

- SugarORM http://satyan.github.io/sugar/

- Realm https://realm.io/docs

- Save Key-Value Data with SharedPreferences https://developer.android.com/training/data-storage/shared-preferences.html#java

- Save Data using SQLite https://developer.android.com/training/data-storage/sqlite.html

- Material icons https://material.io/tools/icons/?style=baseline
