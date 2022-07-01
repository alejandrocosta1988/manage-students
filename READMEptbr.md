# Manage Students | Versão em português

Manage Students é um projeto Java desenvolvido para praticar minhas habilidades em desenvolvimento de software utilizando a linguagem Java junto com uma abordagem de desenvolvimento dirigido por testes (TDD). Meu objetivo foi me familiarizar com TDD, desenvolvimento ágil, e, ao mesmo tempo, colocar em prática conceitos associados ao núcleo da linaguagem de programação.

Manage Students é um software de gerenciamento de estudantes, como pode ser entendido a partir do próprio nome do projeto. Informações sobre a estrutura de classes e novas funcionalidades serão fornecidas conforme novas estórias de usuários forem selecionadas para serem trabalhadas.

## Pacotes

### `studentinfo`

O pacote `studentinfo` contém código relacionado com os estudantes.

#### Classes

`Student` armazena informação de um estudante. Uma instância de `Student` recebe o nome do estudante através do construtor.

### `courseinfo`

O pacote `courseinfo` contém código relacionado com os cursos ofertados.

`CourseSession` armazena informação sobre um curso ofertado (nome do departamento, número do curso, estudantes matriculados no curso ofertado e data inicial). Quando uma instância da classe é criada, o nome do departamento deve ser fornecido, juntamente com o número do curso e a data de início do curso.

Essa classe inclui métodos para retornar estudantes específicos que estão matriculados no curso, bem como para retornar a data de final do curso.