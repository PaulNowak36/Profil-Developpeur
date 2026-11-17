# Profil Développeur

## Description du projet

Dans ce devoir, on affiche la fiche profil d'un étudiant développeur afin de connaître des informations le concernant. En effet, il est composé d'un en-tête avec le nom et le titre du développeur en question, une description courte de celui-ci, un bouton permettant d'afficher ou non la liste des compétences informatiques qu'il possède, et finalement son mail de contact. L'écran possède 2 previews: une preview où les compétences sont montrées, et une autre où les compétences sont masquées.

## Composition du projet

### Thème

Le thème du projet s'intitule **ProfilDeveloppeurTheme**: c'est lui qui gère l'apparence générale de l'applicatione et qui contient le **Scaffold** (l'échafaudage) qui s'occupera de la structure de base de l'écran

### Les différents composables

L'arbre de composition suivant montre la hiérarchie des différents composables du projet:

```
DeveloperScreen
└── DeveloperFile
    ├── Surface
    └── DeveloperFileContent
        └── Column
            ├── DeveloperHeading
            │   └── Surface
            │      └── Column
            │          ├── DeveloperName
            │          │   └── Text
            │          └── DeveloperTitle
            │              └── Text
            ├── DeveloperDescription
            │   └── Text
            ├── DeveloperSkillsSection
            │   ├── Row
            │   │   ├── Text
            │   │   └── ShowSkillsButton
            │   │       └── Button
            │   │           └── Text
            │   └── DeveloperSkillsList
            │       └── Column
            │           ├── DeveloperUniqueSkill
            │               └── Text
            │           ├── DeveloperUniqueSkill
            │               └── Text
            │           └── DeveloperUniqueSkill
            │               └── Text
            │   
            └── DeveloperMail
                └── Text
```
