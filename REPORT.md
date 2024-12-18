Instituto Federal de Ciência e Tecnologia da Paraíba  
Campus Esperança

**Disciplina**  
Sistemas Operacionais

**Docente**  
Artur Luiz Torres de Oliveira

**Discentes**  
Ramon de Oliveira Bento  
Jeferson Freire da Silva  
Kaik Emanuel Alves Aciole  
Abraão Borges Pimenta Azevedo

**Tema do Relatório**  
Problema dos Leitores/Escritores  
**Resumo**  
Conhecido popularmente como um clássico da tecnologia da informação, o problema dos leitores/escritores faz uma analogia a empecilhos comuns em sistemas operacionais, trazendo para uma ótica do mundo físico o problema onde processos compartilham um mesmo recurso. A resolução se dá por meio da gerência de acesso desses processos a um dado recurso, controlando o tempo e ordem de consumo.  
**Introdução**  
A solução proposta foi adotar um sistema de prioridade para o acesso do recurso. O processo leitor permite que outros leitores também acessem o recurso, esperando em uma fila, porém nenhum escritor pode chegar enquanto não terminarem. Para contornar o problema de “starvation”, onde um dos processos espera por muito tempo, o tamanho da fila dos leitores é limitada. Assim, sempre que atingir o limite de leitores, um escritor, caso haja, deve obrigatoriamente tomar posse do recurso, e os leitores devem esperar ele finalizar.   
Usar esse sistema de prioridade é uma solução robusta para o problema dos leitores/escritores, pois garante que ambos processos tenham acesso ao recurso, mas de forma controlada, e esse controle pode ser adaptado para uso em diferentes situações, dependendo do resultado desejado.  
Um escritor jamais pode agir enquanto houver leitores consumindo o recurso. Um escritor jamais pode agir enquanto houver escritores agindo. Porém, ambos podem permitir que outros de sua mesma classe acessem simultaneamente. Vários leitores podem ler por vez, bem como vários escritores podem escrever por vez.

**Metodologia adotada**  
Para implementar o problema e mostrar na prática o que acontece, optamos por usar a linguagem Java e criar um algoritmo simples de gerenciamento de prioridade e acesso. Para isso, importamos o objeto “java.util.concurrent.Semaphore” e os processos “Leitor” e “Escritor” estendem a classe “Thread” que por sua vez implementa a interface “Runnable”.  
Nosso algoritmo não possui um “buffer” lógico, mas apenas uma simulação de acesso. Portanto, assumimos que o dado lido ou escrito está sempre disponível quando um processo chegar para acessá-lo.  
Depois disso, definimos dois semáforos, um para o controle de acessos dos leitores e outro para controle de acesso dos escritores. Dessa forma, o processo que chegar até o recurso pode controlar a entrada de outros processos.  
Definimos também uma variável limite para o tamanho da fila dos leitores. Dado que leitores podem acessar o dado simultaneamente enquanto bloqueiam o acesso aos escritores, foi necessário haver um controle de limite, para que os escritores não ficassem com “fome”, problema no mundo dos sistemas operacionais que se refere a um processo que aguarda muito tempo para consumir o recurso.  
Criamos então, objetos leitores e escritores, de forma manual, que vão disputar o acesso ao recurso. A ordem de chegada é definida pelo sistema operacional, ela é, portanto, randômica a cada nova execução.  
Na prática, se um leitor chegar primeiro, ele irá bloquear o semáforo dos escritores, e permitir a entrada de outro leitores. Quando o limite da fila de leitores for atingido, o último leitor que conseguiu ter acesso ao recurso irá bloquear o semáforo dos próprios leitores, para que, ao terminar seu uso, os escritores realizem o mesmo processo, bloqueando a entrada de novos leitores e permitindo apenas a entrada de outros escritores.  
Com essas ferramentas, fomos capazes de desenvolver um pequeno projeto que simula o problema dos leitores/escritores e apresentamos sua solução, de forma simples e didática, para materializar esse clássico de sistemas operacionais.

**Análise do resultado**  
Após diversas execuções, vimos que  a chegada aleatória dos processos ao recurso cria uma dinâmica de observação interessante, dado que cada nova tentativa mostra um resultado diferente da anterior.  
Nosso algoritmo conseguiu lidar muito bem com o controle de acesso, não podendo ser observado problemas de “starvation” nem “deadlock”. Ambos os processos coexistem de forma harmônica, não monopolizando o recurso e respeitando as regras estabelecidas.

**Conclusão**  
Após extensivos testes e análises, concluímos que o problema dos leitores/escritores tem como solução eficiente o uso de semáforos para o manuseio de “threads”. Se gerenciados por um controle de acesso “booleano”, os processos não irão sobrepujar regras de acesso, nem passar por problemas de espera excessiva.  
Esse método é altamente adaptável para as necessidades do programa em questão e pode ser escalonado com as mais diversas aplicações.

**Referências Bibliográficas**

[Readers-Writers Problem | Set 1 (Introduction and Readers Preference Solution)](https://www.geeksforgeeks.org/readers-writers-problem-set-1-introduction-and-readers-preference-solution/)  
(Acesso: 11/12/2024)

[Sistemas Operacionais: Problema dos Leitores e Escritores com Semáforos (implementado em Java)](https://www.youtube.com/watch?v=n7awXQdDSB0)  
(Acesso: 11/12/2024)

[Problema dos Escritores e Leitores em C | Threads e Semáforos | \- Sistemas Operacionais \- UFC](https://www.youtube.com/watch?v=lznnby8uv_M)  
(Acesso: 11/12/2024)

[16.4 \- Leitor Escritor \[SO UFAM\]](https://www.youtube.com/watch?v=w_y_GUO59ek)  
(Acesso: 11/12/2024)

[Modern Operating Systems 4th Edition \- Andrew Tanenbaum](https://github.com/lighthousand/books/blob/master/Modern%20Operating%20Systems%204th%20Edition--Andrew%20Tanenbaum.pdf)  
(Acesso: 11/12/2024)

[Sistemas Operacionais \- Aula 11 \- Processos: Problema leitores escritores, Escalonamento](https://www.youtube.com/watch?v=8e0mNt97Koo)  
(Acesso: 11/12/2024)

[fael123programming / reader-writer-problem](https://github.com/fael123programming/reader-writer-problem/blob/main/src/models/process/Process.java)  
(Acesso: 11/12/2024)