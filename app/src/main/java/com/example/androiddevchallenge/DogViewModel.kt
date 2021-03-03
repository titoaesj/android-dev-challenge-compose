package com.example.androiddevchallenge

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.model.Dog

class DogViewModel : ViewModel() {

    val dogs: List<Dog> = listOf(
        Dog(
            "Border collie",
            origin = "Reino Unido",
            heightMale = "48–56 cm",
            heightFemale = "46–53 cm",
            weightMale = "14–20 kg",
            weightFamale = "12–19 kg",
            image = R.drawable.border_collie,
            history = "Border collie é uma raça canina do tipo collie desenvolvida na região da fronteira anglo-escocesa na Grã-Bretanha para o trabalho de pastorear gado ovino. Popular em seu país de origem, é considerado a raça de cães mais inteligente do mundo, de acordo com o livro de Stanley Coren, A Inteligência dos Cães."
        ),
        Dog(
            "Golden retriever",
            origin = "Reino Unido",
            heightMale = "51–56 cm",
            heightFemale = "56–61 cm",
            weightMale = "25–32 kg",
            weightFamale = "30–34 kg",
            image = R.drawable.golden_retriever,
            history = "O golden retriever é uma raça canina do tipo retriever originária da Grã-bretanha, e foi desenvolvida para a caça de aves aquáticas."
        ),
        Dog(
            "Husky siberiano",
            origin = "Sibéria",
            heightMale = "50–56 cm",
            heightFemale = "54–60 cm",
            weightMale = "16–23 kg",
            weightFamale = "20–27 kg",
            image = R.drawable.husky_siberiano,
            history = "O husky siberiano é uma raça de cães de trabalho e companhia, do tipo Spitz, oriunda da Sibéria na Rússia. Sua função específica é tracionar trenós."
        ),
        Dog(
            "Pastor-alemão",
            origin = "Alemanha",
            heightMale = "60–65 cm",
            heightFemale = "55–60 cm",
            weightMale = "30–40 kg",
            weightFamale = "22–32 kg",
            image = R.drawable.pastor_alemao,
            history = "Pastor-alemão ou lobo-da-alsácia é uma raça canina proveniente da Alemanha. Em sua origem era utilizado como cão de pastoreio de rebanhos. Atualmente é mais utilizado como cão de guarda e cão policial."
        )
    )

}