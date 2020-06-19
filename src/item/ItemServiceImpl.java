package item;

public class ItemServiceImpl implements ItemService{
	private Item[] list;
	private int index;

	
	public ItemServiceImpl() {
		list = new Item[3];
		index =0;
		
		
	}
	@Override
	public void addCart(Item item) {
		list[index] = item;
		index++;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Item[] list() {
		// TODO Auto-generated method stub
		return list;
	}

}