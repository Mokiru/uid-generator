package cn.momochi.uid.worker;

/**
 * Represents a worker id assigner for {@link cn.momochi.uid.impl.DefaultUidGenerator}
 * 
 * @author yutianbao
 */
public interface WorkerIdAssigner {

    /**
     * Assign worker id for {@link cn.momochi.uid.impl.DefaultUidGenerator}
     * 
     * @return assigned worker id
     */
    long assignWorkerId();

}
