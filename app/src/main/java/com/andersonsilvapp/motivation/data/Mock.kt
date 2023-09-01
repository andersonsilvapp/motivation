package com.andersonsilvapp.motivation.data

import com.andersonsilvapp.motivation.infra.MotivationConstants
import kotlin.random.Random

data class Phrase(val description: String, val categoryId: Int)

class Mock {
  private val all = MotivationConstants.FILTER.ALL
  private val smile = MotivationConstants.FILTER.SMILE
  private val sun = MotivationConstants.FILTER.SUN

  private val mListPhrase = listOf<Phrase>(
    Phrase("Não sabendo que era impossível, foi lá e fez.", smile),
    Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", smile),
    Phrase("Quando está mais escuro, vemos mais estrelas!", smile),
    Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", smile),
    Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", smile),
    Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", smile),
    Phrase("A melhor maneira de prever o futuro é inventá-lo.", sun),
    Phrase("Você perde todas as chances que você não aproveita.", sun),
    Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sun),
    Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sun),
    Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sun),
    Phrase("Se você acredita, faz toda a diferença.", sun),
    Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sun)
  )

  fun getPhrase(categoryId: Int): String {
    var filteredPhrase = mListPhrase.filter { (it.categoryId == categoryId || categoryId == all) }

    val randomNum = Random.nextInt(filteredPhrase.size)

    return filteredPhrase[randomNum].description
  }


}