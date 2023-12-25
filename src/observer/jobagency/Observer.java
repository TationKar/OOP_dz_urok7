package observer.jobagency;

// Наблюдатель, он будет получать уведомления
// В данном случае это человек, ищущий работу, получает уведомления от рекрутингового агенства
public interface Observer {
    void receiveOffer(String nameCompany, int salary);
}
