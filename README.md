Problema 1

Programul este alcătuit din două clase principale: Item și Feed. Clasa Item reprezintă un articol dintr-un RSS și conține informații precum titlul, link-ul, descrierea și data publicării. Clasa Feed reprezintă întregul feed RSS și stochează informațiile generale ale acestuia (titlu, link, descriere), precum și o listă de articole de tip Item.

Programul utilizează biblioteca JSoup pentru a descărca și parsa feed-ul RSS. Mai întâi se selectează elementul channel, din care se extrag informațiile generale ale feed-ului. Apoi sunt selectate toate elementele item din interiorul acestuia. Pentru fiecare item se extrag datele relevante și se creează obiecte de tip Item, care sunt adăugate în lista din Feed. La final, programul parcurge lista de articole și afișează titlul și link-ul fiecărui articol.

Problema 2

Programul definește o funcție Python sub forma unui șir de caractere în Java, care este folosită pentru prelucrarea unui text. Funcția deschide fișierul fisier.in, citește tot conținutul acestuia și aplică mai multe prelucrări folosind expresii regulate (regex).

Spațiile multiple sunt înlocuite cu un singur spațiu, iar newline-urile consecutive sunt reduse la unul singur. De asemenea, sunt eliminate liniile care conțin doar cifre, deoarece acestea reprezintă de obicei numerele de pagină ale ebook-ului.

Pentru a rula codul Python se folosește GraalVM. Programul creează un context GraalVM, evaluează codul Python definit în Java și apoi execută funcția Python pentru a obține textul prelucrat.
