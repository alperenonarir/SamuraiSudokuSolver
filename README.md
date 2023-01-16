# Samurai Sudoku Çözücü

#### -Bu projede  9 X 9 normal sudokuların 5 tanesinin iç içe geçmesiyle oluşmuş samurai sudokular için çözümü bulan algoritma geliştirilmiştir.

#### -sudoku isimli txt dosyasında olan sudokuyu program okur ve çözüm aşamasına geçer.

#### -çözüm için asenkron threadler kullanılmıştır. her tabalo için birer ve ikişer asenkron thread ataması yapılmıştır.

#### -çözüm sonucunda 5 ve 10 thredli çözümlerin performans grafikleri oluşturulmuş ve farklı bir pencere üzerinden gösterilmiştir.

#### -çözüm txt dosyasına yazdırılmıştır. 5 isimli txt dosyasına  5 threadli çözüm, 10 isimli txt dosya 10 threadli çözüm yazdıdırılır.




## Yöntem

threadler rekrüsif bir algoritma ile  çözümü denenmektedir

Proje geliştirme aşamasında asenkron olmaları dolayısı ile threadlerin tıkandığı ve çözümün asenkron diğer threadlerde olduğu gözlemlenmiş ve derinliği artar şekilde sıfırlama işlemi gerçekleştirilerek tıkanıklık en az geri dönüşle giderilmiştir. Kenar karelerden başlanarak orta noktaya doğru derinliği artar şekilde sıfırlanmıştır. sıfırlanmanın tetiklenmesi için adım sayısı belirlenmiştir. 0.5 milyon deneme başarısız olan algoritma derinliği bir arttırarak sıfırlama işlemi yapar. Bu şekilde orta noktalardaki çözümü bulunmuş kareler olabildiğince korunmaya çalışılmış ve "imkansız çözüm" durumunda kalmış tıkanan threadler kurtarılmıştır. SudokuCozucu sınıfında bulunann global değişken denemeSiniri değiştirilerek daha derin çözüm yapması sağlanabilir.



***Program başadığı zaman konsol üzerinden 0 rakamını girerek süreci devam ettirebilirisiniz.***
 
 1-) Txt dosyasının okunması ve sudokunun gösterilmesi. 
 
 2-) 5 Asenkron thread ile çözümü
 
 3-) sudokunun sıfırlanması
 
 4-) 10 threadli çözüm
 
 5-) Performans Karşılaştırma Grafikleri
 


![image](https://user-images.githubusercontent.com/121980906/212634768-a63b7ec1-a26a-4345-919c-45aa92a4a379.png)
![image](https://user-images.githubusercontent.com/121980906/212635769-f8ee0c29-460b-48b3-a32c-edea654c94ad.png)
![image](https://user-images.githubusercontent.com/121980906/212635893-9e141ec8-efae-4ec0-8bbd-9e36a6aad7bd.png)
![image](https://user-images.githubusercontent.com/121980906/212635980-b8b48d62-aff0-47f9-8e01-95a83bb3e01a.png)


