// Fenetre 1 : 
import 'package:flutter/material.dart';
import 'fenetre2.dart';

void main() => runApp(
    const MaterialApp(home: Fenetre1(),)
);

class Fenetre1 extends StatefulWidget {
  const Fenetre1({super.key});

  @override
  State<Fenetre1> createState() => _Fenetre1State();
}

class _Fenetre1State extends State<Fenetre1> {
  final _nom = TextEditingController();
  final _prenom = TextEditingController();
  final _age = TextEditingController();
  String _sexe = 'Homme';

  @override
  Widget build(BuildContext context) {
    return Scaffold(

      appBar: AppBar(
          title: Text("Formulaire", style: TextStyle(color: Colors.white),),
          backgroundColor: Colors.blue[900],
          centerTitle: true
      ),

      body: Center(
        child: Column(
          children: [
            Padding(padding: EdgeInsets.all(5)),
            Row(
              children: [
                Text("Nom : ", style: TextStyle(color: Colors.black, fontSize: 17),),
                Expanded(child:
                  TextField(
                    controller: _nom,
                    decoration: InputDecoration(
                        labelText: "Nom",
                        hintText: "Entrer votre nom...",
                        enabledBorder: OutlineInputBorder(
                          borderSide: BorderSide(color: Colors.grey, width: 1.0)
                        ),
                      focusedBorder: OutlineInputBorder(
                        borderSide: BorderSide(color: Colors.black, width: 2)
                      ),
                      contentPadding: EdgeInsets.symmetric(vertical: 7)
                    ),
                    textInputAction: TextInputAction.next,
                  )
                )
              ],
            ),
            Padding(padding: EdgeInsets.all(5)),
            Row(
              children: [
                Text("Prénom : ", style: TextStyle(color: Colors.black, fontSize: 17),),
                Expanded(
                    child: TextField(
                      controller: _prenom,
                      decoration: InputDecoration(
                        labelText: "Prénom",
                        hintText: "Entrer votre prénom...",
                        contentPadding: EdgeInsets.symmetric(vertical: 7),
                        enabledBorder: OutlineInputBorder(
                          borderSide: BorderSide(color: Colors.grey, width: 1)
                        ),
                        focusedBorder: OutlineInputBorder(
                            borderSide: BorderSide(color: Colors.black, width: 2)
                        ),
                      ),
                      textInputAction: TextInputAction.next,
                    )
                )
              ],
            ),
            Padding(padding: EdgeInsets.all(5)),
            Row(
              children: [
                Text("Age : ", style: TextStyle(color: Colors.black, fontSize: 17),),
                Expanded(
                    child: TextField(
                      controller: _age,
                      decoration: InputDecoration(
                          labelText: "Age",
                          hintText: "Entrer votre age...",
                          contentPadding: EdgeInsets.symmetric(vertical: 7),
                          enabledBorder: OutlineInputBorder(
                              borderSide: BorderSide(color: Colors.grey, width: 1)
                          ),
                          focusedBorder: OutlineInputBorder(
                              borderSide: BorderSide(color: Colors.black, width: 2)
                          ),
                      ),
                    )
                )
              ],
            ),
            Row(
              children: [
                Radio(
                    value: "Homme",
                    groupValue: _sexe,
                    onChanged: (v) => setState(() => _sexe = v!),
                ),
                Text("Homme"),
                Radio(
                    value: "Femme",
                    groupValue: _sexe,
                    onChanged: (v) => setState(() => _sexe = v!),
                ),
                Text("Femme")
              ],
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                ElevatedButton(
                    onPressed: (){
                      Navigator.push(context,
                        MaterialPageRoute(builder: (context) => Fenetre2(
                              nom: _nom.text,
                              prenom: _prenom.text,
                              age: _age.text,
                              sexe: _sexe
                          ),
                        ),
                      );
                    },
                    child: Text("Afficher Résultat"),
                )
              ],
            )
          ],
        ),
      ),
    );

  }
}



// Fenetre 2 : 

import 'package:flutter/material.dart';

class Fenetre2 extends StatelessWidget {
  final String nom;
  final String prenom;
  final String age;
  final String sexe;

  const Fenetre2({
    super.key,
    required this.nom,
    required this.prenom,
    required this.age,
    required this.sexe,
  });

  @override
  Widget build(BuildContext context) {
    return Scaffold(

      appBar: AppBar(
        title: Text("Résultat", style: TextStyle(color: Colors.white),),
        backgroundColor: Colors.blue[900],
        centerTitle: true,
      ),

      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [

            Text("Nom : $nom",
                style: TextStyle(fontSize: 20)
            ),

            SizedBox(height: 10),

            Text("Prénom : $prenom",
                style: TextStyle(fontSize: 20)
            ),

            SizedBox(height: 10),

            Text("Âge : $age",
                style: TextStyle(fontSize: 20)
            ),

            SizedBox(height: 10),

            Text("Sexe : $sexe",
                style: TextStyle(fontSize: 20)
            ),

            SizedBox(height: 30),

            ElevatedButton(
              onPressed: () => Navigator.pop(context),
              child: Text("Retour"),
            ),

          ],
        ),
      ),
    );

  }
}
